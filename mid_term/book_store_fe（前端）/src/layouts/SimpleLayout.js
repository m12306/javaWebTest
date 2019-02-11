import React, { PureComponent } from 'react';
import withRouter from 'umi/withRouter';
import { connect } from 'dva';

class SimpleLayout extends PureComponent {
  render() {
    const { children } = this.props;

    return (
      <div>
        {children}
      </div>
    );
  }
}
export default withRouter(connect(({ app }) => ({ app }))(SimpleLayout));
