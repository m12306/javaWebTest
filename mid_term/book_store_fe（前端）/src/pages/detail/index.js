import React, { PureComponent } from 'react';
import { connect } from 'dva';
import router from 'umi/router';
import { Card, WingBlank, WhiteSpace, Toast, Button, List, NavBar, Icon } from 'antd-mobile';
import { Rate } from 'antd';
import styles from './index.less';

const Item = List.Item;
const Brief = Item.Brief;
@connect(({ detail }) => ({
  detail,
}))
class Detail extends PureComponent {

  componentDidMount() {
    const { match } = this.props;
    this.props.dispatch({
      type: 'detail/getBookById',
      id: match.params.id,
    });
  }
  componentDidUpdate(prevProps, prevState) {
    prevProps.detail.opRes && Toast.info('添加成功', 1);
  }
  addToCart = bookId => {
    console.log(bookId);
    this.props.dispatch({
      type: 'detail/addToCart',
      bookId: bookId,
    });
  };

  render() {
    const { detail } = this.props;
    const book = detail.book;
    return (
      <div className={styles.detail}>
        <NavBar icon={<Icon type="left" />} onLeftClick={() => router.go(-1)} mode="light">
          详情
        </NavBar>
        <div>
          <Card>
            <Card.Body>
              <div className={styles.header}>
                <div className={styles.bookImg}>
                  <img src={`http://localhost:8080/image/${book.id - 1}.jpg`} />
                </div>
              </div>
            </Card.Body>
          </Card>
        </div>
        <div>
          <List
            renderHeader={() => (
              <div>
                <div style={{ fontSize: '1.2em' }}>{book.name}</div>
                <Rate disabled allowHalf value={book.score / 2} />
                <span> {book.score}分</span>
              </div>
            )}
            className="my-list"
          >
            <Item onClick={() => {}}>
              <div className={styles.price}>￥{book.price}</div>
            </Item>
            <Item>
              作者：
              {book.author}
            </Item>
            <Item extra={book.press} arrow="horizontal" onClick={() => {}}>
              出版社：
            </Item>
            <Item extra={book.commentNum} arrow="horizontal" onClick={() => {}}>
              月销：
            </Item>
            <Item extra="选择" align="top" multipleLine>
              送至 <Brief>地址：</Brief>
            </Item>
          </List>
        </div>
        <WhiteSpace />

        <div className={styles.footer}>
          <Button
            type="primary"
            size="large"
            onClick={() => {
              this.addToCart(book.id);
            }}
          >
            加入购物车
          </Button>
        </div>
      </div>
    );
  }
}

export default Detail;
