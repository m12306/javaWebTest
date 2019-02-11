import React, { PureComponent } from 'react';
import { TabBar } from 'antd-mobile';
import Router from 'umi/router';
import PropTypes from 'prop-types';
import BizIcon from '../BizIcon';

const tabBarData = [
  {
    title: '首页',
    icon: 'shouye',
    selectedIcon: 'shouye',
    link: '/index',
  },
  {
    title: '分类',
    icon: 'fenlei',
    selectedIcon: 'fenlei',
    link: '/category',
  },
  {
    title: '购物车',
    icon: 'cart_icon',
    selectedIcon: 'cart_icon',
    link: '/shop',
  },
  {
    title: '我的',
    icon: 'wode',
    selectedIcon: 'wode',
    link: '/me',
  },
];

class MenuBar extends PureComponent {
  render() {
    const { isMenubar, children, pathname } = this.props;
    return (
      <TabBar hidden={isMenubar}>
        {tabBarData.map(({ title, icon, selectedIcon, link }) => (
          <TabBar.Item
            key={link}
            title={title}
            icon={<BizIcon type={icon} />}
            selectedIcon={<BizIcon type={selectedIcon} />}
            selected={pathname === link}
            onPress={() => Router.push(`${link}`)}
          >
            {/* 匹配到的children路由进行渲染 */}
            {children.props.location.pathname === link && children}
          </TabBar.Item>
        ))}
      </TabBar>
    );
  }
}

MenuBar.defaultProps = {
  isMenubar: false,
  children: null,
  pathname: '/',
};

MenuBar.propTypes = {
  isMenubar: PropTypes.bool,
  children: PropTypes.node,
  pathname: PropTypes.string,
};

export default MenuBar;
