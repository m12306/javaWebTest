import * as BookAPI from '../../services/index';
import { stat } from 'fs';
export default {
  namespace: 'category',
  state: {
    list: [],
    page: 0,
  },
  effects: {
    *getAllBooks(actions, { call, put }) {
      let listResult = yield BookAPI.getAllBooks();
      yield put({
        type: 'putBooks',
        list: listResult,
      });
    },
    *getBookByPage(actions, { select, call, put }) {
      let page = yield select(state => state.category.page);
      let res = yield BookAPI.getBookByPage(page);
      console.log(page);
      if (res.length > 0) {
        yield put({
          type: 'setPage',
        });
      }
      yield put({
        type: 'pushBooks',
        list: res,
      });
    },
  },
  reducers: {
    putBooks(state, { list }) {
      return { ...state, list };
    },
    pushBooks(state, { list }) {
      return { ...state, list: [...state.list, ...list] };
    },
    setPage(state) {
      return { ...state, page: state.page + 1 };
    },
  },
};
