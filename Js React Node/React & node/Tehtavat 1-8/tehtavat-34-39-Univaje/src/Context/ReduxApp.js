import React from 'react';
import { createStore } from "redux";
import { connect } from "react-redux";

// Install redux and react-redux packages first
// npm install redux
// npm install react-redux


export default class ReduxApp extends React.Component
{
    constructor(props)
    {
        super();

        this.addArticleClicked = this.addArticleClicked.bind(this);

        this.state = {
            data : "",
            id: 1
        }

        // This is not needed when you use react-redux!
        store.subscribe(() => {
            let s = store.getState();
            console.log('New article added, count is now : ', s.articles);
        })
    }    

    getStateClicked()
    {
        // This is not needed when you use react-redux!
        let d = store.getState();
        console.log("d=", d);
    }

    addArticleClicked()
    {
        this.setState((p) => ({id : p.id+1}))
        // This is not needed when you use react-redux!
        //store.dispatch({ type: ADD_ARTICLE, title: this.state.data, id: this.state.id });                
        store.dispatch( addArticle({ title: this.state.data, id: this.state.id }) )        
    }

    render()
    {
        return(
            <div>
                <p>This part is for (plain) Redux</p>
                <label>
                    Data for redux
                    <input type="text" onChange={(e) => this.setState({data :e.target.value })} />
                </label>
                <button onClick={this.getStateClicked}>Get state</button>
                <button onClick={this.addArticleClicked}>Add article</button>

                <br />
                <p>This part is for React Redux</p>
                <Form />
                <List />
                <StudentList />
            </div>
        );
    }
}

// ACTION TYPE
const ADD_ARTICLE = "ADD_ARTICLE";
const DELETE_ARTICLE = "DELETE_ARTICLE";
const ADD_STUDENT = "ADD_STUDENT";

// REDUCER
const initialState = {
    articles: [],
    students: []
  };
  
// NOTE! Immutable state! 
// The resulting state is a copy of the current state added with the new data.
function rootReducer(state = initialState, action) {
    if (action.type === ADD_ARTICLE) {
        // Create a copy (clone) of current state -> Object.assign
        // Then combine old array with new article
        return Object.assign({}, state, {articles: state.articles.concat(action.payload)} );
    }
    else if (action.type === DELETE_ARTICLE)
    {
        return Object.assign({}, state, {articles: state.articles.filter(a => a.id !== action.payload.id)} );
    }
    else if (action.type === ADD_STUDENT) {
        return Object.assign({}, state, {students: state.students.concat(action.payload)} );
    }

    return state; 
};

// STORE
// reducers produce the state of your application.
export const store = createStore(
    rootReducer,
    // Add the following line for Redux DevTools
    window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__()
    );

// ACTIONS
// It is a best pratice to wrap every action within a function. 
// Such function is an action creator.
function addArticle(payload) {
    return { type: ADD_ARTICLE, payload }
  };

function deleteArticle(payload) {
    console.log("deleteArticle : ", payload);
    return { type: DELETE_ARTICLE, payload : payload }
  };

function addStudent(payload) {
    return { type: ADD_STUDENT, payload }
  };


// React-redux part
const mapStateToProps = state => {
    return { allArticles: state.articles };
};

const mapStudentsToProps = state => {
    return { allStudents : state.students };
}

const List = connect(mapStateToProps)(ArticleList);
// React-redux part

const StudentListComponent = (props) => {
    return (
        <div>
            <p>Here are all the students</p>
            <ul>
                {props.allStudents.map((s, i) => <li key={i}>{s.nimi}</li>)}
            </ul>
        </div>
    )
}

function ArticleList(props) 
{
    const data = props.allArticles.map( (a, index) => <li key={index}>{a.title}</li>);

    return(
        <div>
            <p>See list of articles</p>
            <ul>
                {data}
            </ul>
        </div>
    )
}

const StudentList = connect(mapStudentsToProps)(StudentListComponent);

class ArticleForm extends React.Component
{
    constructor(props)
    {
        super();

        this.handleOnClick = this.handleOnClick.bind(this);
        this.handleTitleChange = this.handleTitleChange.bind(this);
        this.handleDeleteOnClick = this.handleDeleteOnClick.bind(this);

        this.state = {
            title : null,
            id : 1
        }
    }

    handleTitleChange(event)
    {
        this.setState({title : event.target.value});
    }

    handleOnClick()
    {
        let title = this.state.title;
        let id = this.state.id;
        this.props.addNewArticle({ title, id });
        this.setState({id : id + 1});
    }

    handleDeleteOnClick()
    {
        let id = parseInt(this.state.title);
        this.props.deleteTheArcticle({id: id, title : ''});
    }

    render()
    {
        return(
            <div>
                <form>
                    <label htmlFor="title">Title</label>
                    <input type="text" id="title" onChange={this.handleTitleChange}/>
                </form>
                <button onClick={this.handleOnClick}>Add an article</button>
                <button onClick={this.handleDeleteOnClick}>Delete an article</button>
                <button onClick={() => { this.props.addStudent({ nimi: this.state.title });}}>Add student</button>
            </div>
        )
    }
}

// React-redux part
function mapDispatchToProps(dispatch) {
    return {
      addNewArticle: article => dispatch(addArticle(article)),
      deleteTheArcticle: article => dispatch(deleteArticle(article)),
      addStudent : student => dispatch(addStudent(student))
    };
  }

const Form = connect(null, mapDispatchToProps)(ArticleForm);
// React-redux part