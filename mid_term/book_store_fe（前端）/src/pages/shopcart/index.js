import React, { PureComponent } from 'react';
import { connect } from 'dva';
import { List, NavBar, Checkbox, Card, WhiteSpace, Stepper } from 'antd-mobile';
const Item = List.Item;
import styles from './index.less';
import CartItem from './CartItem';
@connect(({ shopcart }) => ({
  shopcart,
}))
class ShopCart extends PureComponent {
  componentDidMount() {
    this.props.dispatch({ type: 'shopcart/getAllCart' });
  }
  onChange = (val, cartItemId,bookId) => {
    console.log(val);
    if (val === 0) {
      this.props.dispatch({
        type: 'shopcart/deleteCart',
        id: cartItemId,
      });
    } else {
      this.props.dispatch({
        type: 'shopcart/modify',
        data: {
          quantity: val,
          id: cartItemId,
          bookId:bookId
        },
      });
    }
  };
  onOrderChange = (checked, book) => {
    let { bookId, quantity, price ,bookName} = book;
    if (checked) {
      this.props.dispatch({
        type: 'shopcart/addOrder',
        data: {
          bookId,
          quantity,
          price,
          bookName
        },
      });
    } else {
      this.props.dispatch({
        type: 'shopcart/deleteOrder',
        book: { bookId, quantity, price },
      });
    }
  };
  submitOrder=()=>{
    this.props.dispatch({
      type:'shopcart/submitOrder'
    })
  }
  render() {
    const { route, shopcart } = this.props;
    const list = shopcart.list;
    return (
      <div className={styles.main}>
        <NavBar mode="light">{route.title}</NavBar>
        <List>
          {list.map(book => (
            <div key={book.bookId}>
              <WhiteSpace size="lg" />
              <CartItem onOrderChange={this.onOrderChange} onChange={this.onChange} book={book} />
            </div>
          ))}
        </List>
        <List className={styles.submitOrder}>
          <Item onClick={this.submitOrder} extra={<div >提交订单</div>}>
            <div className={styles.price}>￥{shopcart.totalPrice}</div>
          </Item>
        </List>
      </div>
    );
  }
}
export default ShopCart;
