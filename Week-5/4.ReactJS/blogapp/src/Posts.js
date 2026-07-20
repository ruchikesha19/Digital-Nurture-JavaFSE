import React from 'react';
import Post from './Post';

class Posts extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            posts: [],
            error: null
        };
    }

    loadPosts() {
        fetch('https://jsonplaceholder.typicode.com/posts')
            .then(response => {
                if (!response.ok) {
                    throw new Error('Failed to fetch posts');
                }
                return response.json();
            })
            .then(data => {
                const postsList = data.map(p => new Post(p.id, p.title, p.body));
                this.setState({ posts: postsList });
            })
            .catch(error => {
                console.error("Failed to load posts:", error);
                this.setState({ error: error.message });
            });
    }

    componentDidMount() {
        this.loadPosts();
    }

    componentDidCatch(error, info) {
        alert("An error occurred inside Posts component: " + error.toString());
    }

    render() {
        if (this.state.error) {
            return (
                <div style={{ padding: '20px', color: 'red' }}>
                    <h2>Error loading posts: {this.state.error}</h2>
                </div>
            );
        }
        return (
            <div style={{ padding: '20px', maxWidth: '800px', margin: '0 auto', fontFamily: 'sans-serif' }}>
                <h1>Blog Posts</h1>
                {this.state.posts.map(post => (
                    <div key={post.id} style={{ borderBottom: '1px solid #eaeaea', padding: '15px 0' }}>
                        <h3 style={{ color: '#333', textTransform: 'capitalize' }}>{post.title}</h3>
                        <p style={{ color: '#666', lineHeight: '1.6' }}>{post.body}</p>
                    </div>
                ))}
            </div>
        );
    }
}

export default Posts;
