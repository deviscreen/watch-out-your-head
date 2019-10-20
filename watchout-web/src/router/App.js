import React, { Component } from 'react';

import Header from 'container/Header';
import Container from 'container/Container';

class App extends Component {
    render() {
        return (
            <div>
                <Header></Header>
                <Container></Container>
            </div>
        );
    }
}

export default App;