import React, { PureComponent } from 'react';
import { connect } from 'dva';
import router from 'umi/router';
import { List, NavBar, WingBlank, Card, WhiteSpace, Icon } from 'antd-mobile';
import styles from './index.less';
import OrderItem from './OrderItem';
const Item = List.Item;
@connect(({ order }) => ({
  order,
}))
class Order extends PureComponent {
  componentDidMount() {
    this.props.dispatch({ type: 'order/getAllOrders' });
  }

  render() {
    const { route, order } = this.props;
    return (
      <div>
        <NavBar icon={<Icon type="left" />} onLeftClick={() => router.go(-1)} mode="light">
          {route.title}
        </NavBar>
        <List>
          {order.orders.map(order => (
            <OrderItem order={order} key={order.orderDetail.id} />
          ))}
        </List>
      </div>
    );
  }
}
export default Order;
