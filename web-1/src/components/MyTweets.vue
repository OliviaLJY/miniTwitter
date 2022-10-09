<template>
    <div>
        <div class="container-1">
            <b-row>
            <b-col>
                <div style="padding:30px">
                    <div style="width:100%;text-align:center">
                        <b-img id="twitter-img" :src="twitter"  ></b-img>
                    </div>

                    <div @click="changeToAllTweets" class="setting-text"><strong>AllTweets</strong></div>
                </div>
            </b-col>
            <b-col cols="7" class="content" style="text-align:center">
                <p class="p-3">
                        <b-list-group style="text-align:left">
                            <b-list-group-item
                                v-for="item in showTweetList"
                                :key="item.id"
                            >
                            <div>
                                <strong>{{item.title}}</strong>
                            </div>
                            <div style="text-indent:2rem">
                                {{item.cotent}}
                                <b-button @click="update(item)" size="sm" variant="outline-danger"  style="float:right">update</b-button>
                                <b-button @click="deleteTweet(item.id)" size="sm" variant="outline-danger"  style="float:right">delete</b-button>
                            </div>
                            </b-list-group-item>
                        </b-list-group>
                        <template>
                            <b-pagination
                            v-if="rows>0"
                            @change="changePage"
                            v-model="currentPage"
                            :total-rows="rows"
                            per-page="10"
                            aria-controls="my-table"
                            ></b-pagination>
                            <div v-if="rows==0">do not have any tweets</div>
                        </template>
                    </p>
            </b-col>
            <b-col> </b-col>
            </b-row>
        </div>

        <b-modal  @ok="updateOk" v-model="updateModalShow">
            <b-form>
                <b-form-group  id="input-group-2" label="title:" label-for="title">
                    <b-form-input
                        id="title"
                        v-model="tweetForm.title"
                        required
                        placeholder="Enter title"
                    ></b-form-input>
                </b-form-group>
                <b-form-group  id="input-group-2" label="cotent:" label-for="cotent">
                    <b-form-textarea
                        id="textarea"
                        rows="3"
                        v-model="tweetForm.cotent"
                        required
                        placeholder="Enter cotent"
                    ></b-form-textarea>
                </b-form-group>
            </b-form>
        </b-modal>
    </div>
</template>

<script>
    import {getAllTweets,deleteTweet,updateTweet } from './api.js'
    export default {
        data() {
            return {
                twitter:require('../assets/twitter.png'),
                showTweetList: [],
                tweetList: [],
                currentPage:1,
                tweetForm:{},
                updateModalShow:false,
                rows:0
            }
        },
        mounted(){
            this.initData()
        },
        methods: {
            changeToAllTweets(){
                this.$router.push('/')
            },
            updateOk(bvModalEvt){
                bvModalEvt.preventDefault();
                updateTweet(this.tweetForm).then(res=>{
                    if(res.data.success){
                            alert(res.data.message)
                            this.updateModalShow = false
                            this.initData()
                        }else{
                            alert(res.data.message)
                        }
                })
            },
            update(item){
                this.tweetForm = item
                this.updateModalShow = true
            },
            deleteTweet(id){
                deleteTweet(id).then(res=>{
                    if(res.data.success){
                            alert(res.data.message)
                            this.initData()
                        }else{
                            alert(res.data.message)
                        }
                })
            },
            changePage(page){
                 this.showTweetList = this.tweetList.slice(10*(page-1),10*(page))
            },
            initData() {
                getAllTweets().then(res=>{
                    if(localStorage.getItem('id').length == 0)
                        return;
                    this.tweetList = res.data.filter(val=>{
                        return val.authorId == localStorage.getItem('id')
                    })
                    this.showTweetList = this.tweetList.slice(0,10)
                    this.rows = this.tweetList.length
                    console.log(this.showTweetList)
                })
            },
        },
    }
</script>

<style scoped>
#twitter-img{
    width:80px;
    height:80px
}
#search-img{
    width:40px;
    height:40px
}
#input-group-2{
    padding-top:10px
}
.content{
    height:890px;
    border: 1px solid #bbb;
    border-radius: 5px;
}
.setting-text{
    border-radius: 5px;
    background-color: #ddd;
    cursor: pointer;
    font-size:25px;
    padding :10px;
    margin-top:10px
}
.container-1{
    padding-top: 20px;
}
.sign-btn-div{
    width:100%;
    text-align: center;
    margin-top:20px
}
.sign-btn{
    width:80%;
    padding:10px;
    border-radius: 20px;
}
.t-1{
    font-size: 18px;
    font-weight: bolder;
}

</style>
