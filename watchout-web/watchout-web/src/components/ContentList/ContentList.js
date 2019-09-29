import React,{ Component } from 'react';
import Content from '../Content/Content';
import './ContentList.css'
class ContentList extends Component{

    render(){
        return (
            <div className="content-list">
                <Content></Content>
                <Content></Content>
                <Content></Content>
            </div>
        )
    }
}

export default ContentList;