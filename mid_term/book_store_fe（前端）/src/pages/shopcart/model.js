import * as BookAPI from '../../services/index';
import { stat } from 'fs';
export default {
  namespace: 'shopcart',
  state: {
    list: [],
    order: [],
    totalPrice: 0,
  },
  effects: {
    *getAllCart(actions, { put, call }) {
      const res = yield BookAPI.getCart();
      if (res) {
        yield put({
          type: 'putCart',
          list: res,
        });
      }
    },
    *deleteCart({ id }, { put, call }) {
      const res = yield BookAPI.deleteCart(id);
      yield put({ type: 'delete', id: id });
    },
    *modify({ data }, { put, call }) {
      const res = yield BookAPI.modifyCart(data);
      yield put({ type: 'setOrderItem', data });
      yield put({
        type: 'calcPrice',
      });
    },
    *addOrder({ data }, { put, call }) {
      console.log(data);
      yield put({
        type: 'addOrderItem',
        book: data,
      });
      yield put({
        type: 'calcPrice',
      });
    },
    *deleteOrder({ book }, { put, call }) {
      yield put({
        type: 'deleteOrderItem',
        id: book.bookId,
      });
      yield put({
        type: 'calcPrice',
      });
    },
    *submitOrder(actions, { put, call, select }) {
      let order = yield select(state => state.shopcart.order);
      let totalPrice = yield select(state => state.shopcart.totalPrice);
      let data = { book: order, price: totalPrice };
      yield BookAPI.submitOrder(data);
      console.log(data);
      yield put({
        type: 'submitSuccess',
      });
    },
  },
  reducers: {
    putCart(state, { list }) {
      return { ...state, list };
    },
    delete(state, { id }) {
      const { list } = state;
      const res = list.filter(item => item.id !== id);
      console.log(res);
      return { ...state, list: res };
    },
    addOrderItem(state, { book }) {
      const { order } = state;
      return { ...state, order: [book, ...order] };
    },
    deleteOrderItem(state, { id }) {
      const { order } = state;
      const res = order.filter(item => item.bookId !== id);
      console.log(res);
      return { ...state, order: res };
    },
    setOrderItem(state, { data }) {
      const { list, order } = state;
      order.map(item => {
        console.log(item, data);
        if (item.bookId === data.bookId) item.quantity = data.quantity;
      });
      return { ...state, order };
    },
    submitSuccess(state) {
      const { order, list } = state;
      let orderIds = order.map(item => item.bookId);
      const newList = list.filter(item => {
        return !orderIds.includes(item.bookId);
      });
      return { ...state, totalPrice: 0, list: newList, order: [] };
    },
    calcPrice(state) {
      const { order } = state;
      let price = order.reduce((accumulator, current) => {
        return accumulator + current.price * current.quantity;
      }, 0);
      return { ...state, totalPrice: price };
    },
  },
};
