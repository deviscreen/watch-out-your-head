import React , {Component} from 'react';
import './SearchBar.css';
class SearchBar extends Component{

    render(){
        return (
            <div className="search">
                <input placeholder="검색"></input>
            </div>
        )
    }

}
export default SearchBar;