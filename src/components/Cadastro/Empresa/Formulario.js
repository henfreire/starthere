import React from 'react';
import Stepper from '@material-ui/core/Stepper'; import Step from '@material-ui/core/Step'; import StepLabel from '@material-ui/core/StepLabel';
import Button from '@material-ui/core/Button';
import Checkbox from '@material-ui/core/Checkbox';
import TextField from '@material-ui/core/TextField';
import Typography from '@material-ui/core/Typography';
import IntlMessages from 'util/IntlMessages';
import { renderTextField, renderRadio } from 'components/Formularios/ReduxFields';
import { Field, reduxForm } from 'redux-form';
import Pergunta1 from './pergunta1';
import Pergunta2 from './pergunta2';
import Pergunta3 from './pergunta3';
import Pergunta4 from './pergunta4';
import Pergunta5 from './pergunta5';
import Pergunta6 from './pergunta6';
import { totalmem } from 'os';

function getSteps() {
    return ['Tempo de atuação da Startup', 'Número de diversidade técnica da empresa', 'Desenvolvimento do projeto', 'Investimento recebido','Tempo disponível médio por membro da equipe semanalmente','Lucro mensal','Confirmação'];
}


function getStepContent(stepIndex,getState) {

  

    switch (stepIndex) {
        case 0:
            return <Pergunta1 getState={getState}/>;
        case 1:
            return <Pergunta2 getState={getState}/>;
        case 2:
            return <Pergunta3 getState={getState}/>;
        case 3:
            return <Pergunta4 getState={getState}/>;
        case 4:
            return <Pergunta5 getState={getState}/>;
        case 5:
            return <Pergunta6 getState={getState}/>;

        default:
            return 'Confirme para ser ranqueado!';
    }
}

// const PerguntaUm = () =>
//   (<div>
//     <Pergunta1/>
//   </div>);

// const PerguntaDois = () =>
//   (<div>
//     <Pergunta2/>
//   </div>);
  
// const PerguntaTres = () =>
//   (<div>
//     <Pergunta3/>
//   </div>);

// const PerguntaQuatro = () =>
//   (<div>
//     <Pergunta4/>
//   </div>);

// const PerguntaCinco = () =>
//   (<div>
//     <Pergunta5/>
//   </div>);

// const PerguntaSeis = ({getState}) =>
//   (<div>
//     <Pergunta6 getState={getState}  />
//   </div>);



class FormularioSequencia extends React.Component {
    state = {
        activeStep: 0,
        total:0
    };

    handleNext = () => {
        const { activeStep } = this.state;
        this.setState({
          total: this.getState()+this.state.total,
      });
        this.setState({
            activeStep: activeStep + 1,
        });


    };

    handleBack = () => {
        const { activeStep } = this.state;
        this.setState({
            activeStep: activeStep - 1,
        });
    };

    handleReset = () => {
        this.setState({
            activeStep: 0,
        });
    };

    getState = (valor) => {
      console.log("asdasdasdasdasda",valor)
      return valor;
    };


    render() {
        const steps = getSteps();
        const { activeStep } = this.state;

        return (
            <div className="w-100">
                <Stepper activeStep={activeStep} alternativeLabel className="horizontal-stepper-linear">
                    {steps.map((label, index) => {
                        return (
                            <Step key={label} className={`horizontal-stepper ${index === activeStep ? 'active' : ''}`}>
                                <StepLabel className="stepperlabel">{label}</StepLabel>
                            </Step>
                        );
                    })}
                </Stepper>
                <div>
                    {this.state.activeStep === steps.length ? (
                        <div>
                            <Typography className="my-2">
                                All steps completed - you&quot;re finished
                            </Typography>
                            <Button onClick={this.handleReset}>Reset</Button>
                        </div>
                    ) : (
                            <div>
                                {getStepContent(activeStep,this.getState)}
                                <div>
                                    <Button
                                        disabled={activeStep === 0}
                                        onClick={this.handleBack}
                                        className="mr-2"
                                    >
                                        Voltar
                                </Button>
                                    <Button variant="raised" color="primary" onClick={this.handleNext}>
                                        {activeStep === steps.length - 1 ? 'Concluir' : 'Próximo'}
                                    </Button>
                                </div>
                            </div>
                        )}
                </div>
            </div>
        );
    }
}

export { FormularioSequencia };