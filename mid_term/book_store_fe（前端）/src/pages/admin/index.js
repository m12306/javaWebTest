import React, { PureComponent } from 'react';
import { connect } from 'dva';
import router from 'umi/router';
import { List, NavBar, Modal, Toast, WingBlank, Card, WhiteSpace, Button, Icon } from 'antd-mobile';
const Item = List.Item;

@connect(({ 
  admin }) => ({
  admin,
}))
class Admin extends PureComponent {
  state = {
    newBookInfo: {},
    userModal: false,
    bookModal: false,
  };
  componentWillMount() {}
  componentDidMount() {
    this.props.dispatch({
      type: 'admin/getAllOrders',
    });
    this.props.dispatch({
      type: 'admin/getAllUser',
    });
  }
  dateTrans = date => {
    return new Date(date).toLocaleDateString();
  };
  modifyOrder = (id, status) => {
    this.props.dispatch({
      type: 'admin/modify',
      id,
      status,
    });
  };
  showModal = key => e => {
    e.preventDefault(); // 修复 Android 上点击穿透
    this.setState({
      [key]: true,
    });
  };
  onClose = key => () => {
    this.setState({
      [key]: false,
    });
  };
  closest = (el, selector) => {
    const matchesSelector =
      el.matches || el.webkitMatchesSelector || el.mozMatchesSelector || el.msMatchesSelector;
    while (el) {
      if (matchesSelector.call(el, selector)) {
        return el;
      }
      el = el.parentElement;
    }
    return null;
  };
  onWrapTouchStart = e => {
    // fix touch to scroll background page on iOS
    if (!/iPhone|iPod|iPad/i.test(navigator.userAgent)) {
      return;
    }
    const pNode = this.closest(e.target, '.am-modal-content');
    if (!pNode) {
      e.preventDefault();
    }
  };
  render() {
    const { route, admin } = this.props;
    let orders = admin.orders;
    let users = admin.users;
    return (
      <div>
        <NavBar icon={<Icon type="left" />} onLeftClick={() => router.go(-1)} mode="light">
          {route.title}
        </NavBar>
        <Button type="primary" onClick={this.showModal('bookModal')} style={{ margin: '10px' }}>
          添加书籍
        </Button>

        <Modal
          visible={this.state.bookModal}
          transparent
          // maskClosable={false}
          onClose={this.onClose('bookModal')}
          title="Title"
          wrapProps={{ onTouchStart: this.onWrapTouchStart }}
          footer={[
            {
              text: 'Ok',
              onPress: () => {
                console.log('ok');
                this.onClose('bookModal')();
              },
            },
          ]}
        >
          <div style={{ height: 150, overflow: 'scroll' }}>
          {/* <InputItem
                value={this.state.book}
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
              </InputItem> */}
          </div>
        </Modal>

        <Button onClick={this.showModal('userModal')} type="primary" style={{ margin: '10px' }}>
          查看用户
        </Button>
        <Modal
          visible={this.state.userModal}
          transparent
          // maskClosable={false}
          onClose={this.onClose('userModal')}
          title="Title"
          wrapProps={{ onTouchStart: this.onWrapTouchStart }}
          footer={[
            {
              text: 'Ok',
              onPress: () => {
                console.log('ok');
                this.onClose('userModal')();
              },
            },
          ]}
        >
          <div style={{ height: 150, overflow: 'scroll' }}>
            {users.map(user => {
              return (
                <div key={user.id}>
                  <span>username: {user.username}</span>
                  <br />
                </div>
              );
            })}
            <br />
          </div>
        </Modal>
        <List>
          {orders.map((order, index) => (
            <WingBlank key={order.orderDetail.id} size="lg">
              <WhiteSpace size="lg" />
              <Card key={index}>
                <Card.Header
                  title="订单"
                  extra={
                    <Button
                      inline
                      size="small"
                      type="primary"
                      onClick={() => {
                        this.modifyOrder(order.orderDetail.id, !order.orderDetail.state);
                      }}
                    >
                      {order.orderDetail.state ? '未完成' : '完成'}
                    </Button>
                  }
                />
                <Card.Body>
                  <div>
                    {order.book.map(book => (
                      <Item key={book.id}>
                        <span>{book.bookName}</span>
                        <span>X{book.quantity}</span>
                      </Item>
                    ))}
                  </div>
                </Card.Body>
                <Card.Footer
                  content={this.dateTrans(order.orderDetail.orderTime)}
                  extra={<div>￥{order.orderDetail.price}</div>}
                />
              </Card>
              <WhiteSpace size="lg" />
            </WingBlank>
          ))}
        </List>
      </div>
    );
  }
}
export default Admin;
