import * as BookAPI from '../../services/index';
export default {
  namespace: 'order',
  state: {
    orders: [],
  },
  effects: {
    *getAllOrders(action, { put, call }) {
      const res = yield BookAPI.getOrder();
      yield put({
        type: 'setOrder',
        res,
      });
    },
  },
  reducers: {
    setOrder(state,{ res }) {
      return { ...state, orders: res };
    },
  },
};
