import firebase from 'firebase';

// Initialize Firebase
const config = {
 apiKey: "AIzaSyDA4TH6IZutZ83hiOIaMwtuF5l_3Zdkl9o",
    authDomain: "starthere-da73b.firebaseapp.com",
    databaseURL: "https://starthere-da73b.firebaseio.com",
    projectId: "starthere-da73b",
    storageBucket: "starthere-da73b.appspot.com",
    messagingSenderId: "262218977093"
};

firebase.initializeApp(config);
const auth = firebase.auth();

const googleAuthProvider = new firebase.auth.GoogleAuthProvider();
const facebookAuthProvider = new firebase.auth.FacebookAuthProvider();
const githubAuthProvider = new firebase.auth.GithubAuthProvider();
const twitterAuthProvider = new firebase.auth.TwitterAuthProvider();

const database = firebase.database();
export {
    auth,
    database,
    googleAuthProvider,
    githubAuthProvider,
    facebookAuthProvider,
    twitterAuthProvider
};