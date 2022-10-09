<template>
    <div class="container-1">
        <b-row>
            <b-col>
                <div style="padding:30px">
                    <div style="width:100%;text-align:center">
                        <b-img id="twitter-img" :src="twitter"  ></b-img>
                    </div>

                    <div @click="reset" class="setting-text"><strong>MyProfile</strong></div>
                    <div @click="changeToMyTweets" class="setting-text"><strong>MyTweets</strong></div>
                    <div @click="showCreateModal" class="setting-text"><strong>CreateTweets</strong></div>
                </div>
            </b-col>
            <b-col cols="7" class="content" style="text-align:center">
                <div style="padding-top:10px" >
<!--                    <b-input-group   >-->
<!--                        <b-input-group-prepend>-->
<!--                             <b-img id="search-img" :src="search"  ></b-img>-->
<!--                        </b-input-group-prepend>-->
<!--                        <b-form-input style="border-radius: 5px;"></b-form-input>-->
<!--                        <template v-slot:append>-->
<!--                            <b-button variant="success">Search</b-button>-->
<!--                        </template>-->
<!--                    </b-input-group>-->
                    <b-tabs pills card end content-class="mt-3">
                        <b-tab  active>
                            <template #title>
                                <strong>For you</strong>
                            </template>
                        </b-tab>
                    </b-tabs>
                    <p class="p-3">
                        <b-list-group style="text-align:left">
                            <b-list-group-item
                                v-for="item in showTweetList"
                                :key="item.id"
                            >
                            <div>
                                <strong>{{item.title}}
                                    <span style="color:#bbb;float:right" >
                                    <span v-if="item.username!=null" >{{item.username}}-</span>({{item.createTime}})
                                    </span></strong>
                            </div>
                            <div style="text-indent:2rem">
                                {{item.cotent}}
                                <b-button @click="like(item.id)" size="sm" variant="outline-danger"  style="float:right">like({{item.likes}})</b-button>
                            </div>
                            </b-list-group-item>
                        </b-list-group>

                        <b-pagination
                        @change="changePage"
                        v-model="currentPage"
                        :total-rows="rows"
                        per-page="10"
                        aria-controls="my-table"
                        ></b-pagination>
                    </p>
                </div>
            </b-col>
            <b-col style="padding:20px">
                <p class="t-1">New to Twitter?</p>
                <p class="t-2">Sign up now to get your own personalized timeline!</p>
                <div v-if="!isLogin" class="sign-btn-div"><b-button @click="sign" class="sign-btn" variant="outline-success">sign with account</b-button></div>
                <div v-if="isLogin" class="sign-btn-div"><b-button @click="out" class="sign-btn" variant="outline-success">logout</b-button></div>
                <div class="sign-btn-div"><b-button @click="register" class="sign-btn" variant="outline-primary">create account</b-button></div>
            </b-col>
        </b-row>
         <b-modal  @ok="ok" v-model="modalShow">
           <template #modal-ok><strong>{{comfirmStr}}</strong></template>
           <b-form>
               <b-form-group  id="input-group-2" label="username:" label-for="username">
                    <b-form-input
                    id="username"
                    v-model="form.username"
                    required
                    placeholder="Enter username"
                    ></b-form-input>
                </b-form-group>
                <b-form-group  id="input-group-2" label="name:" label-for="name">
                    <b-form-input
                    id="name"
                    v-model="form.name"
                    required
                    placeholder="Enter name"
                    ></b-form-input>
                </b-form-group>
                <b-form-group id="input-group-2" label="password:" label-for="password">
                    <b-form-input
                    id="password"
                    v-model="form.password"
                    required
                    placeholder="Enter password"
                    ></b-form-input>
                </b-form-group>
           </b-form>
         </b-modal>

        <b-modal  @ok="createOk" v-model="createModalShow">
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
         <b-modal  @ok="changeOk" v-model="changeModalShow">
             <b-form>
               <b-form-group  id="input-group-2" label="oldPassword:" label-for="oldPassword">
                    <b-form-input
                    id="oldPassword"
                    v-model="changeForm.oldPassword"
                    required
                    placeholder="Enter username"
                    ></b-form-input>
                </b-form-group>
                <b-form-group id="input-group-2" label="newPassword:" label-for="newPassword">
                    <b-form-input
                    id="newPassword"
                    v-model="changeForm.newPassword"
                    required
                    placeholder="Enter password"
                    ></b-form-input>
                </b-form-group>
                <b-form-group  id="input-group-2" label="checkNewPassword:" label-for="checkNewPassword">
                    <b-form-input
                    id="checkNewPassword"
                    v-model="changeForm.checkNewPassword"
                    required
                    placeholder="Enter checkNewPassword"
                    ></b-form-input>
                </b-form-group>
           </b-form>
         </b-modal>
    </div>
</template>

<script>
    import _XEUtils_ from 'xe-utils'
    import {createUser,login,createTweet,getAllTweets,likeTweet,resetPassword,logout } from './api.js'
    export default {
        data() {
            return {
                rows:0,
                currentPage:1,
                name: '',
                modalShow:false,
                comfirmStr:null,
                form:{},
                changeForm:{},
                twitter:require('../assets/twitter.png'),
                search:require('../assets/search.png'),
                changeModalShow:false,
                showSuc:false,
                showErr:false,
                errMsg:null,
                createModalShow:false,
                tweetForm:{},
                tweetList:[],
                showTweetList:[],
                isLogin:false
            }
        },
        mounted(){
            if(localStorage.getItem('token')!=null){
                this.isLogin = true
            }
            this.showSuc = true
            this.initData()
        },
        methods: {
          showCreateModal(){
            if(this.isLogin == false){
              this.comfirmStr = 'sign'
              this.modalShow = true
              return
            }
            this.createModalShow = true
          },
            out(){
                if(localStorage.getItem('token')==null){
                    this.isLogin = false
                    return
                }
                logout(localStorage.getItem('token')).then(res=>{
                    if(res.data.success){
                            localStorage.clear()
                            alert('logout success')
                            this.isLogin = false
                        }else{
                            alert(res.data.message)
                        }
                })
            },
            changeToMyTweets(){
              if(this.isLogin == false){
                this.comfirmStr = 'sign'
                this.modalShow = true
                return
              }
                this.$router.push('/MyTweets')
            },
            like(id){
              if(this.isLogin == false){
                this.comfirmStr = 'sign'
                this.modalShow = true
                return
              }
                likeTweet(id).then(res=>{
                    if(res.data.success){
                            alert('success')
                            this.initData()
                            //this.createModalShow = false
                        }else{
                            alert(res.data.message)
                        }
                })
            },
            changePage(page){
                 this.showTweetList = this.tweetList.slice(10*(page-1),10*(page))
            },
            initData(){
                getAllTweets().then(res=>{
                    this.tweetList = res.data
                    this.tweetList.forEach(val=>{
                        val.createTime = _XEUtils_.toDateString(val.createTime)
                    })
                    this.rows = res.data.length
                    this.showTweetList = this.tweetList.slice(0,10)
                })
            },
            createOk(bvModalEvt){
                bvModalEvt.preventDefault();
                console.log(this.tweetForm)
                this.tweetForm.like = 0
                this.tweetForm.authorid = localStorage.getItem('id')
                createTweet(this.tweetForm).then(res=>{
                    if(res.data.success){
                            alert(res.data.message)
                            this.createModalShow = false
                            this.initData()
                        }else{
                            alert(res.data.message)
                        }
                })
            },
            reset(){
              if(this.isLogin == false){
                this.comfirmStr = 'sign'
                this.modalShow = true
                return
              }
                this.comfirmStr = 'reset'
                this.modalShow = true
            },
            sign() {
                this.comfirmStr = 'sign'
                this.modalShow = true
            },
            register(){
                this.form = {}
                this.comfirmStr = 'register'
                this.modalShow = true
            },
            ok(bvModalEvt){
                bvModalEvt.preventDefault();
                if(this.comfirmStr == 'register'){
                    createUser(this.form).then(res=>{
                        console.log(res)
                        if(res.data.success){

                            alert('register success')
                            this.modalShow = false
                        }else{
                            alert(res.data.message)
                        }
                    })
                }else if(this.comfirmStr == 'reset'){
                    resetPassword(this.form).then(res=>{
                        console.log(res)
                        if(res.data.success){
                            alert('Password has been reset successfully')
                            this.isLogin = true
                            this.modalShow = false
                        }else{
                            alert(res.data.message)
                        }
                    })
                }else{
                    localStorage.removeItem('token')
                    login(this.form).then(res=>{
                        if(res.data.success){
                            localStorage.setItem('token',res.data.responseData.token)
                            localStorage.setItem('id',res.data.responseData.id)
                            this.isLogin = true
                            alert('login success')
                            this.modalShow = false
                        }else{
                            alert(res.data.message)
                        }
                    })

                }
                //alert(1);this.modalShow = false
            }
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
