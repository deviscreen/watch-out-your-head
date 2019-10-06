import React , {Component} from 'react';
import './Content.css'
class Content extends Component{
    render(){

        return (
            <div className="content-wrap">
                <div className="content-header">
                    <div>Title</div>
                    <div>Date</div>
                    <div>Ask User</div>
                </div>
                <div>Content List</div>
                <div>
                    <div>content-footer</div>
                </div>
            </div>
        )

    }
}
export default Content;