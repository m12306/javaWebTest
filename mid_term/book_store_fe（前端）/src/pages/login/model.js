import * as BookAPI from '../../services/index';
import router from 'umi/router';
export default {
  namespace: 'user',
  state: {
    loginStatus: false,
    token: '',
    registerRes: '',
    message: '',
  },
  subscriptions: {
    setup({ history, dispatch }) {
      return history.listen(({ pathname }) => {
        const token = localStorage.getItem('token');
        if (pathname === '/login' && token) {
          router.replace('/index');
        }
      });
    },
  },
  effects: {
    *login({ data }, { put, call }) {
      let res = yield BookAPI.login(data);
      if (res.status == 1) {
        yield put({
          type: 'setLoginStatus',
          token: res.token,
        });
        localStorage.setItem('token', res.token);
        localStorage.setItem('username', data.username);
        router.replace('/index');
      }
    },
    *register({ data }, { put, call }) {
      let res = yield BookAPI.register(data);
      let status = res.status === 0 ? false : true;
      yield put({ type: 'setRegStastus', message: res.message, registerRes: true });
      yield put({ type: 'setRegStastus', message: res.message, registerRes: false });
    },
  },
  reducers: {
    setLoginStatus(state, { token }) {
      return { ...state, loginStatus: true, token: token };
    },
    setRegStastus(state, { message, registerRes }) {
      return { ...state, registerRes, message };
    },
  },
};
