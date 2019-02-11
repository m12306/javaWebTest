import React, { PureComponent } from 'react';
import { connect } from 'dva';
import router from 'umi/router';
import { List, NavBar, WingBlank, Card, WhiteSpace, Icon } from 'antd-mobile';
import styles from './index.less';
const Item = List.Item;
class OrderItem extends PureComponent {

  dateTrans = date => {
    return new Date(date).toLocaleDateString();
  };
  render() {
    const {  order } = this.props;
    return (
        <WingBlank key={order.orderDetail.id} size="lg">
              <WhiteSpace size="lg" />
              <Card className={styles.orderDetail}>
                <Card.Header
                  title="订单"
                  extra={<div>{order.orderDetail.state ? '已收货' : '未收货'}</div>}
                />
                <Card.Body>
                  <div>
                    {order.book.map(book => (
                      <Item className={styles.orderBook} key={book.id}>
                        <span>{book.bookName}</span>
                        <span className={styles.orderStatus}>X{book.quantity}</span>
                      </Item>
                    ))}
                  </div>
                </Card.Body>
                <Card.Footer
                  content={this.dateTrans(order.orderDetail.orderTime)}
                  extra={<div className={styles.totalPrice}>{order.orderDetail.price}</div>}
                />
              </Card>
              <WhiteSpace size="lg" />
            </WingBlank>
    );
  }
}
export default OrderItem;
