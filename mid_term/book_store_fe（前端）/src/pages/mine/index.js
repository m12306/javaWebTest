import React, { PureComponent } from 'react';
import { Card, NavBar, WingBlank, WhiteSpace, Button, List } from 'antd-mobile';
const Item = List.Item;
const Brief = Item.Brief;
import router from 'umi/router';
import styles from './index.less';

class Mine extends PureComponent {
  singOut = () => {
    localStorage.removeItem('token');
    router.replace('/login');
  };
  render() {
    return (
      <div>
        <NavBar mode="light">我的</NavBar>
        <Card full>
          <Card.Body>
            <div className={styles.mine}>
              <div className={styles.avatarBox}>
                <img src="https://os.alipayobjects.com/rmsportal/QBnOOoLaAfKPirc.png" />
              </div>
              <div>{localStorage.getItem('username')}</div>
            </div>
          </Card.Body>
        </Card>

        <List renderHeader={() => '我的'} className="my-list">
          <Item
            arrow="horizontal"
            multipleLine
            onClick={() => {
              router.push('/order');
            }}
          >
            订单 <Brief>全部订单</Brief>
          </Item>
          <Item arrow="horizontal" multipleLine onClick={() => {}}>
            账户
            <Brief>99999999.99</Brief>
          </Item>
        </List>
        <List renderHeader={() => '关于'} className="my-list">
          <Item arrow="horizontal">About us</Item>
        </List>
        <Button
          type="primary"
          onClick={() => {
            this.singOut();
          }}
          style={{ margin: '10px' }}
        >
          退出登录
        </Button>
      </div>
    );
  }
}
export default Mine;
