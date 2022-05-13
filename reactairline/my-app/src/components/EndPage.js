
import 'bootstrap/dist/css/bootstrap.min.css';
import { Link, useHistory, useParams } from 'react-router-dom';
import { useState } from 'react/cjs/react.development';
import airlineService from '../services/airline.service';
import './Ansar.css'

const EndPage = () => {
    

    const{feedbackId} = useParams();
    const [feedbackDescription , setFeedbackDescription] = useState('')
    const [rating , setRating] = useState('');

    const history = useHistory();
    const submitFeedback = (e) =>{
        e.preventDefault();
        
        const feedback = {feedbackDescription , rating};
        
        if(feedbackDescription==="" || rating===""){
            if(feedbackDescription==="")
                document.getElementById("vdesc").innerText="PROVIDE DESCRIPTION";
            else
            document.getElementById("vdesc").innerText="";

            if(rating==="")
                document.getElementById("vrate").innerText="PROVIDE RATING";
            else
            document.getElementById("vrate").innerText="";

        }
        else{
            document.getElementById("vrate").innerText="";
            document.getElementById("vdesc").innerText="";


        airlineService.createFeedback(feedback)
            .then(response => {
                console.log("FeedBack added successfully", response.data);
                setFeedbackDescription("")
                setRating("")
             history.goBack();
            })
            .catch(error => {
                console.log('something went wrong', error);
            })
        }
        }

    
    

    return (
        <div className="body">
            <div id="regbody">
            <nav class="navbar navbar-dark bg-dark fixed-top">
  <a class="navbar-brand" href="#">
    <img src="travel.png" width="40" height="40" 
    class="d-inline-block align-top" alt="xxxxx"></img>
    FlyHigh
  </a>
  <div></div>
  <div></div>
  <div></div>
  <div></div>
  <div></div>
  <div></div>
  <div id="welcome">Welcome To FlyHigh</div>
  <div></div>
  <div></div>
  <div></div>
  <div></div>
              <div>
          <Link className="btn btn-info" to={`/login`}  >
              LOGOUT</Link>
              </div>          
        </nav>
    
        <div>
<br/>
<br/>
<br/>
          <div className="container">
          <p class="loginhead">Please give us your feedback..</p>
          <form>
                <div className="form-group">
                    <input 
                        type="text" 
                        className="form-control col-4"
                        id="feedbackdescription"
                        value={feedbackDescription}
                        onChange={(e) => setFeedbackDescription(e.target.value)}
                        placeholder="PROVIDE FEEDBACK"
                    />
                <p id="vdesc"></p>

                </div>
                <div className="form-group">
                    <input 
                        type="text" 
                        className="form-control col-4"
                        id="rating"
                        value={rating}
                        onChange={(e) => setRating(e.target.value)}
                        placeholder="RATE BY 10"
                    />
                </div>
                <p id="vrate"></p>
                <div >
                    <button onClick={(e)=>submitFeedback(e)}className="btn btn-primary">
                      SUBMIT</button>
                </div>
              </form>
          </div>

        </div>
        </div>
    </div>
      
    );
}
 
export default EndPage;

