import React,{ Component } from 'react';
import Content from '../Content/Content';

class ContentList extends Component{

    render(){
        return (
            <div>
                <Content></Content>
                <Content></Content>
                <Content></Content>
            </div>
        )
    }
}

export default ContentList;