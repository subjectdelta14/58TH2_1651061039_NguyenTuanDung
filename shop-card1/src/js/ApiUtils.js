import axios from "axios";



export default  function ApiFunction(url ,type, data ) {
    // Default options are marked with *
    const fullApi = "http://localhost:8888/api/" + url;
    
    if(type == "GET"){
        return  getData(fullApi);
    }else if(type=="POST"){

        return  postData(fullApi,data);
    }else if(type=="PUT"){
        return  putData(fullApi,data);
    }else if(type=="FILE"){
        return  postDataWithFile(fullApi,data)
    }
    return  null;

}

 function postData(fullApi, data){
    
    const response =  axios(fullApi, {
        method: "POST", // *GET, POST, PUT, DELETE, etc.
        mode: 'cors', // no-cors, *cors, same-origin
        cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
        credentials: 'same-origin', // include, *same-origin, omit
        headers: {
           
            'Content-Type': 'application/json',
            // 'Content-Type': 'application/x-www-form-urlencoded',
          
        },
        redirect: 'follow', // manual, *follow, error
        referrerPolicy: 'no-referrer', // no-referrer, *no-referrer-when-downgrade, origin, origin-when-cross-origin, same-origin, strict-origin, strict-origin-when-cross-origin, unsafe-url
        data: JSON.stringify(data) // body data type must match "Content-Type" header
    }).then(response => {
        if(!response.ok){
            return { data: response.status }
        }
        else {
            return response.json();
        }
            
    }).then(response => response.data);

    return response; // parses JSON response into native JavaScript objects
}

 function postDataWithFile(fullApi, data){
    const response =  axios(fullApi, {
        method: "POST", // *GET, POST, PUT, DELETE, etc.
        mode: 'cors', // no-cors, *cors, same-origin
        cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
        credentials: 'same-origin', // include, *same-origin, omit
        headers: {
            // 'Content-Type': 'application/x-www-form-urlencoded',
        },
        redirect: 'follow', // manual, *follow, error
        referrerPolicy: 'no-referrer', // no-referrer, *no-referrer-when-downgrade, origin, origin-when-cross-origin, same-origin, strict-origin, strict-origin-when-cross-origin, unsafe-url
        body: data // body data type must match "Content-Type" header
    }).then(response => response.data);
    return response; // parses JSON response into native JavaScript objects
}

 function putData(fullApi, data){
   const response =  axios(fullApi, {
       method: "PUT", // *GET, POST, PUT, DELETE, etc.
       mode: 'cors', // no-cors, *cors, same-origin
       cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
       credentials: 'same-origin', // include, *same-origin, omit
       headers: {
           'Content-Type': 'application/json'
           // 'Content-Type': 'application/x-www-form-urlencoded',
       },
       redirect: 'follow', // manual, *follow, error
       referrerPolicy: 'no-referrer', // no-referrer, *no-referrer-when-downgrade, origin, origin-when-cross-origin, same-origin, strict-origin, strict-origin-when-cross-origin, unsafe-url
       body: data // body data type must match "Content-Type" header
   }).then(response => response.json()).then(response => response.data);
   return response; // parses JSON response into native JavaScript objects
}

async function getData(fullApi){
    let responses = await axios(fullApi, {
       method: "GET", // *GET, POST, PUT, DELETE, etc.
       mode: 'cors', // no-cors, *cors, same-origin
       cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
       credentials: 'same-origin', // include, *same-origin, omit
       headers: {
       
          
        'Content-Type': 'application/json',
        'responseType': "arraybuffer"
       },
       redirect: 'follow', // manual, *follow, error
       referrerPolicy: 'no-referrer' // no-referrer, *no-referrer-when-downgrade, origin, origin-when-cross-origin, same-origin, strict-origin, strict-origin-when-cross-origin, unsafe-url
 
   }).then(response => { 
     return response.data
   });
   return responses; // parses JSON response into native JavaScript objects
 }
