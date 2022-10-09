import axios from 'axios';
// create an axios instance
var service = null

  service = axios.create ({
    baseURL:'/minitwitter',
    withCredentials: true, // send cookies
    timeout: 20000, // request timeout
  });

// request interceptor
service.interceptors.request.use (
  config => {
    if (localStorage.getItem ('token') != null) {
      config.headers['token'] = localStorage.getItem ('token');
    }else{
    }
    return config;
  },
  error => {
    // Do something with request error
    console.log (error); // for debug
    console.log ("error"); // for debug
    return Promise.reject (error);
  }
);
//response interceptor
service.interceptors.response.use (
  Response => {
    return Response
});

export default service;
