import React from 'react';
import { slide as Menu } from 'react-burger-menu';
import './Sidebar.css';
import Home from './Home';
// ...

export default props => {
  return (
    <Menu>
      <a className="menu-item" href="/">
        Home 1
      </a>
      <a className="menu-item" href="/salads">
        home 2
      </a>
      <a className="menu-item" href="/pizzas">
        home 3
      </a>
      <a className="menu-item" href="/desserts">
        home 4
      </a>
    </Menu>
  );
};