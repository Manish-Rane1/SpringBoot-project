
function saveData(){
    let username = document.getElementById('Username').value
    let password = document.getElementById('Password').value
    let account = document.getElementById('Account').value

    document.getElementById('Username').value=""
    document.getElementById('Password').value=""
    document.getElementById('Account').value=""

    axios.post(
        "http://localhost:8080/user/save",
        {
          "account":account,
          "username":username,
          "password":password
        },
        {
          headers: {
            "Content-Type": "application/json",
          }
        }
      ).then(response =>{
        if(response.status == 200){
            alert("Saved Successfully!!")
        }
      })
      .catch(error =>{
        alert("No account is added with this name")
      })
}

function getData(){
    let account = document.getElementById('Account').value
    axios.get("http://localhost:8080/user/"+account)
    .then(response =>{
        //document.getElementById('Para').innerHTML= JSON.stringify(response.data);
        document.getElementById('Username').value = response.data.username;
        document.getElementById('Password').value = response.data.password;
    })
    .catch(error=>{
        alert("No account is added with this name")
    })
}

function Delete(){
  let account = document.getElementById('Account').value
  if(confirm("Are you sure you want to delete "+account+" information"))
    

    document.getElementById('Username').value=""
    document.getElementById('Password').value=""
    document.getElementById('Account').value=""
    
    axios.delete("http://localhost:8080/user/"+account)
    .then(response=>{
        if(response.status == 200){
            alert("Deleted Succesfully!!")
        }
    })
    .catch(error=>{
        alert("No account is added with this name")
    })
}