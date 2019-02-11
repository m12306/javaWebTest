import React, { PureComponent } from 'react';
import { List, InputItem, WingBlank, WhiteSpace, Toast,Card, Button } from 'antd-mobile';
import { Form } from 'antd';
import { connect } from 'dva';
import coverImg from '../../assets/cover.png';
import styles from './index.less';

class Login extends PureComponent {
  state = {
    logOrReg: true,
    username: '',
    password: '',
    phone: '',
    address: '',
  };
  componentDidUpdate(prevProps, prevState) {
    prevProps.user.registerRes  &&Toast.info(prevProps.user.message, 1);
  }
  handleClick = () => {
    this.inputRef.focus();
  };
  setLogOrReg = () => {
    this.setState(prevState => {
      return { logOrReg: !prevState.logOrReg };
    });
  };
  login = () => {
    let { username, password } = this.state;
    console.log({ username, password });
    this.props.dispatch({ type: 'user/login', data: { username, password } });
  };
  register = () => {
    let { username, password, phone, address } = this.state;
    this.props.dispatch({ type: 'user/register', data: { username, password, phone, address } });
    console.log({ username, password, phone, address });
  };
  render() {
    return (
      <div className={styles.main}>
        <div className={styles.info}>
          <img className={styles.coverImg} src={coverImg} />
        </div>
        <WingBlank size="lg">
          <WhiteSpace size="lg" />
          <div>
            <h1 style={{ paddingLeft: '10px', fontWeight: 'bold' }}>
              {this.state.logOrReg ? '登录' : '注册'}
            </h1>
          </div>
          <Card>
            <div>
              <InputItem
                value={this.state.username}
                onChange={val => {
                  this.setState({ username: val });
                }}
                placeholder="username"
              >
                用户名
              </InputItem>
              <InputItem
                value={this.state.password}
                onChange={val => {
                  this.setState({ password: val });
                }}
                type="password"
                placeholder="******"
              >
                密码
              </InputItem>
            </div>
            {this.state.logOrReg ? (
              <div />
            ) : (
              <div>
                <InputItem
                  type="phone"
                  value={this.state.phone}
                  onChange={val => {
                    this.setState({ phone: val });
                  }}
                  placeholder="166 6666 6666"
                >
                  手机
                </InputItem>
                <InputItem
                  value={this.state.adress}
                  onChange={val => {
                    this.setState({ adress: val });
                  }}
                  placeholder="火星"
                >
                  地址
                </InputItem>
              </div>
            )}
            <Card.Footer
              extra={
                <div
                  onClick={() => {
                    this.setLogOrReg();
                  }}
                >
                  {!this.state.logOrReg ? '登录' : '注册'}
                </div>
              }
            />
          </Card>
          <WhiteSpace size="lg" />
          <Button
            onClick={() => {
              this.state.logOrReg ? this.login() : this.register();
            }}
            type="primary"
          >
            {this.state.logOrReg ? '登录' : '注册'}
          </Button>
        </WingBlank>
      </div>
    );
  }
}

export default connect(({ user }) => ({ user }))(Form.create()(Login));
