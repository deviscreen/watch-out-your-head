import React, { Component } from 'react';
import { Route } from 'react-router-dom';
import { Home, About, SignUp, Login } from 'pages';

class Container extends Component {
    render() {
        return (
            <div>
                <Route exact path='/' component={Home}></Route>
                <Route path='/about' component={About}></Route>
                <Route path='/sign-up' component={SignUp}></Route>
                <Route path='/login' component={Login}></Route>
            </div>
        );
    }
}

export default Container;