import React from 'react';
import './App.css';
import ContentList from './components/ContentList/ContentList';
import MainTitle from './components/MainTitle/MainTitle';
import SearchBar from './components/SearchBar/SearchBar';
import MainCategory from './components/MainCategory/MainCategory';
import SideBar from './components/SideBar/SideBar';
function App() {
  return (
    <div className="App">
      {/* <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header> */}
      <MainTitle/>
      <div>
        <SearchBar/>
        <MainCategory/>
      </div>
      <div>
        <ContentList/>
        <SideBar/>
      </div>
      
    </div>
  );
}

export default App;
