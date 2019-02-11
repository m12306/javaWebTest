import React, { PureComponent } from 'react';
import { connect } from 'dva';
import { Checkbox, Card, WhiteSpace, Stepper } from 'antd-mobile';
import styles from './index.less';

const CheckboxItem = Checkbox.CheckboxItem;

class CartItem extends PureComponent {
  componentDidMount() {}

  state = this.props.book;
  onBookChange = e => {
    this.props.onOrderChange(e.target.checked, this.props.book);
  };
  onChange = val => {
    this.setState({ quantity: val }, this.props.onChange(val, this.state.id,this.state.bookId));
  };
  render() {
    const book = this.state;
    return (
      <Card full>
        <Card.Body>
          <div className={styles.checkitem}>
            <CheckboxItem
              className={styles.check}
              key={book.id}
              onChange={e => this.onBookChange(e)}
            />
            <div className={styles.book}>
              <div className={styles.bookImg}>
                <img src={`http://localhost:8080/image/${book.bookId - 1}.jpg`} />
              </div>
              <div className={styles.bookInfo}>
                <div> {book.bookName}</div>
                <div>{book.bookAuthor}</div>
                <WhiteSpace size="lg" />
                <div className={styles.price}>￥{book.price}</div>
              </div>
            </div>
          </div>
        </Card.Body>
        <Card.Footer
          extra={
            <Stepper
              style={{ width: '90%', minWidth: '100px' }}
              showNumber
              max={10}
              min={0}
              value={book.quantity}
              onChange={this.onChange}
            />
          }
        />
      </Card>
    );
  }
}
export default CartItem;
