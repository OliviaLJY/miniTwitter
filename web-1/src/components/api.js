import request from "@/utils/request.js";
export function createUser(userPostRequest){
    return request.post('/user/createUser',userPostRequest)
}
export function login(userPostRequest){
    return request.post('/user/login',userPostRequest)
}

export function createTweet(tweetRequest){
    return request.post('/tweets/createTweet',tweetRequest)
}

export function getAllTweets(){
    return request.get('/getAllTweets')
}

export function likeTweet(tweetId){
    return request.put(`/tweets/likeTweet/${tweetId}`)
}

export function resetPassword(userPostRequest){
    return request.put('/user/resetPassword',userPostRequest)
}

export function getTweetsByAuthorId(tweetRequest){
    return request.post('/tweets/getTweetsByAuthorId',tweetRequest)
}

export function deleteTweet(tweetId){
    return request.delete(`/tweets/deleteTweet/${tweetId}`)
}

export function updateTweet(tweetRequest){
    return request.put('/tweets/updateTweet',tweetRequest)
}

export function logout(token){
    return request.get(`/user/logout/${token}`)
}
