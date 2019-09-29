new Vue({
    el:"#app",
    data:{
        user:{
            id:"",
            username:"",
            password:"",
            email:"",
            age:"",
            sex:"",
        },
        userList:[]
    },
    created(){
        this.findAll();
    },
    methods:{
        findAll:function(){
            //在当前方法中定义一个变量，表明是vue对象
            var _this = this;
            // alert("111111");


            // axios({
            //     method:'get',
            //     url:'http://localhost:8080/user/findAll',
            //     withCredentials: true,
            //     crossDomain:true
            // }).then(res=>{
            //     alert("2222222222");
            //     alert(res.data);
            // }).catch(function (error) {
            //     alert(error);
            // })

            // this.userList='[{"id,":4,"username":"shiyanlou","password":"password","email":"邮箱占位符","age":"年龄占位符","sex":"性别占位符"},{"id,":5,"username":"shiyanlou","password":"password","email":"邮箱占位符","age":"年龄占位符","sex":"性别占位符"},{"id,":6,"username":"shiyanlou","password":"password","email":"邮箱占位符","age":"年龄占位符","sex":"性别占位符"}]';
            axios.get('http://localhost:8080/user/findAll',{
                withCredentials: true})
                .then(function (response) {
                    alert("2222222222");
                    _this.userList = response.data;//响应数据给userList赋值
                    console.log(response);
                })
                .catch(function (error) {
                    alert(error);
                    console.log(error);
                })
        },



        /*findAll:function(){
             var _this=this;
             axios.get('127.0.0.1:8080/user/findAll')
                 .then(function(response){
                     _this.userList=response.data;
                 }).catch(function(error){
                     console.log(error);
                 })
         },*/
        findById:function(userid){
            axios.get('url',{params:{id:userid}})
        },
        update:function(user){

        }
    }
})
