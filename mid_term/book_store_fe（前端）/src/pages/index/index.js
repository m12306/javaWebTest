import React, { Component } from 'react';
import PropTypes from 'prop-types';
import { NavBar, Carousel, WingBlank } from 'antd-mobile';
import { connect } from 'dva';
import BookItem from './components/BookItem';
@connect(({ choice }) => ({
  choice,
}))
class Index extends Component {
  componentDidMount() {
    this.props.dispatch({ type: 'choice/getChoiceBook' });
  }
  render() {
    const { route, choice } = this.props;
    return (
      <div style={{maxHeight:"100vh"}}>
        <NavBar mode="light">{route.title}</NavBar>
        <WingBlank>
          <Carousel className="space-carousel" dots={false} cellSpacing={20}>
            {choice.choosenBookList.map((book, index) => (
              <div key={index}>
                <BookItem book={book} />
              </div>
            ))}
          </Carousel>
        </WingBlank>
      </div>
    );
  }
}
export default Index;
