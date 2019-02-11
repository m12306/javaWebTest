import * as BookAPI from '../../services/index';
export default {
  namespace: 'admin',
  state: {
    orders: [],
    users: [],
  },
  effects: {
    *getAllOrders(action, { put, call }) {
      const res = yield BookAPI.getAllOrders();
      yield put({
        type: 'setOrder',
        res,
      });
    },
    *modify({ id, status }, { put, call }) {
      const res = yield BookAPI.modifyOrder(status, id);
      yield put({
        type: 'changeOrderStatus',
        id,
        status,
      });
    },
    *getAllUser(actions, { put, call }) {
      const res = yield BookAPI.getAllUser();
      yield put({
        type: 'putUser',
        data: res,
      });
    },
  },
  reducers: {
    setOrder(state, { res }) {
      const flatten = arr => arr.reduce((a, b) => a.concat(Array.isArray(b) ? flatten(b) : b), []);
      let calcRes = flatten(res);
      return { ...state, orders: calcRes };
    },
    changeOrderStatus(state, { id, status }) {
      const { orders } = state;
      const trans = [...orders];
      trans.map(item => {
        console.log(item.orderDetail.id === id);
        if (item.orderDetail.id === id) {
          item.orderDetail.state = status;
        }
      });
      return { ...state, orders: trans };
    },
    putUser(state, { data }) {
      return { ...state, users: data };
    },
  },
};
