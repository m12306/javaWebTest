import React, { PureComponent } from 'react';
import ReactDOM from 'react-dom';
import router from 'umi/router';
import { connect } from 'dva';
import { Card, WingBlank, WhiteSpace, NavBar, Icon, PullToRefresh } from 'antd-mobile';
import { Rate } from 'antd';
import styles from './index.less';

@connect(({ category }) => ({
  category,
}))
class Category extends PureComponent {
  constructor(props) {
    super(props);
    this.state = {
      refreshing: false,
      down: false,
      height: document.documentElement.clientHeight,
    };
  }
  componentDidMount() {
    const hei = this.state.height - ReactDOM.findDOMNode(this.ptr).offsetTop;
    this.setState({
      height: hei,
    }),
      this.props.dispatch({ type: 'category/getBookByPage' });
  }
  refreshData = () => {
    this.props.dispatch({ type: 'category/getBookByPage' });
  };
  goDetail = val => {
    router.push(`/detail/${val}`);
  };
  render() {
    const { route, category } = this.props;
    const choosenBooks = category.list;
    return (
      <div className={styles.index}>
        <NavBar mode="light">{route.title}</NavBar>{' '}
        <PullToRefresh
          damping={60}
          ref={el => (this.ptr = el)}
          style={{
            height: this.state.height,
            overflow: 'auto',
          }}
          indicator={{ deactivate: '上拉可以刷新' }}
          direction="up"
          refreshing={this.state.refreshing}
          onRefresh={() => {
            this.refreshData();
          }}
        >
          {choosenBooks.map((book, index) => (
            <WingBlank size="lg" key={index}>
              <WhiteSpace size="lg" />
              <Card>
                <Card.Header title={book.name} extra={<span>{book.author}</span>} />
                <Card.Body
                  onClick={() => {
                    this.goDetail(book.id);
                  }}
                >
                  <div className={styles.book}>
                    <div className={styles.bookImg}>
                      <img src={`http://localhost:8080/image/${book.id - 1}.jpg`} />
                    </div>
                    <div className={styles.bookInfo}>
                      <div>“{book.description}”</div>
                      <WhiteSpace />
                      <div>
                        <Rate disabled allowHalf value={book.score / 2} />{' '}
                        <span className={styles.rate}> {book.score}分</span>
                      </div>
                      <WhiteSpace />
                      <div>
                        {book.commentNum}
                        人评价
                      </div>
                    </div>
                  </div>
                </Card.Body>
                <Card.Footer content={book.press} extra={<div>{book.price}元</div>} />
              </Card>
              <WhiteSpace size="lg" />
            </WingBlank>
          ))}
        </PullToRefresh>
      </div>
    );
  }
}

export default Category;
