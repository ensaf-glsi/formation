import './App.css';
import { useEffect, useState } from 'react';

/*StopWatch */
export default function App() {
  return (
    <div className="App">
      <StopWatch />
    </div>
  );
}

function StopWatch() {
  const [state, setState] = useState('stoped');
  const isStoped = state === 'paused';
  const isStarted = state === 'started';
  const isActive = ['paused', 'started'].includes(state);

  const [time, setTime] = useState(0);
  
  useEffect(() => {
    let interval = null;
  
    if (isStarted) {
      interval = setInterval(() => {
        setTime((time) => time + 10);
      }, 10);
    } else {
      clearInterval(interval);
    }
    return () => {
      clearInterval(interval);
    };
  }, [isStarted]);
  
  const handleStart = () => {
    setState('started')
  };
  
  const handlePauseResume = () => {
    setState(isStarted ? 'paused' : 'started')
  };
  
  const handleReset = () => {
    setState('stoped');
    setTime(0);
  };
  
  return (
    <div>
      <Timer time={time} />
      <ControlButtons
        active={isActive}
        isStoped={isStoped}
        handleStart={handleStart}
        handlePauseResume={handlePauseResume}
        handleReset={handleReset}
      />
    </div>
  );
}

function Timer(props) {
  return (
    <div className='timer'>
      <span>
        {("0" + Math.floor((props.time / 60000) % 60)).slice(-2)}:
      </span>
      <span>
        {("0" + Math.floor((props.time / 1000) % 60)).slice(-2)}.
      </span>
      <span>
        {("0" + ((props.time / 10) % 100)).slice(-2)}
      </span>
    </div>
  );
}

function ControlButtons(props) {
  const StartButton = (
    <div className="btn btn-one btn-start btn-primary"
         onClick={props.handleStart}>
      Start
    </div>
  );
  const ActiveButtons = (
    <div>
      <div className="bouton" 
           onClick={props.handleReset}>
        Reset  |
      </div>
      <div className="bouton" 
           onClick={props.handlePauseResume}>
        {props.isStoped ? "Start" : "►   Stop"}
      </div>
    </div>
  );
  
  return (
    <div className="bouton">
      <div>{props.active ? ActiveButtons : StartButton}</div>
    </div>
  );
}