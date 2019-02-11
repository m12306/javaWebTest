import * as BookAPI from '../../services/index';
export default {
  namespace: 'detail',
  state: {
    book: {},
    opRes: false,
  },

  effects: {
    *getBookById({ id }, { call, put }) {
      let res = yield BookAPI.getBookById(id);
      yield put({
        type: 'setBook',
        book: res,
      });
    },
    *addToCart({ bookId }, { call, put }) {
      console.log('data');
      let res = yield BookAPI.addToCart(bookId);
      console.log(res);
      if (res) {
        yield put({
          type: 'setCartStatus',
          opRes: true,
        });
        yield put({
          type: 'setCartStatus',
          opRes: false,
        });
      }
    },
  },
  reducers: {
    setBook(state, { book }) {
      return { ...state, book };
    },
    setCartStatus(state, { opRes }) {
      return { ...state, opRes };
    },
  },
};
