import {  Component , Input, OnInit,ViewChild} from '@angular/core';
import { QuestionService } from './question-service';
import { Question } from './question';
import { CountdownModule, CountdownComponent} from 'ngx-countdown';
import { ActivatedRoute } from '@angular/router';

@Component({
   selector: 'form-quiz',  
   templateUrl: './form-quiz.component.html',
})


export class FormQuizComponent implements OnInit
{
   questions:Question[];
   ans:any[]=[];
   marks:number=0;
   displayMarks:boolean=false;
   clicked :boolean=false;
   takeTestClicked :boolean=false;
   @ViewChild('cd', { static: false }) countdown: CountdownComponent;
   tid : number;
   title : string;
   count : number = 0;
   total : number = 0;
   

    public constructor(private questionService:QuestionService,private activatedRoute: ActivatedRoute){}

    public getqts():void
    {
       this.takeTestClicked =true;
       this.getQuestions(this.tid);
       console.log("test id is : ",this.tid);
    }

    public getQuestions(testId: number):void
    {
       this.takeTestClicked =true;
       this.questionService.getQuestions(testId).subscribe(data => this.questions=data);
    }
        
    getMarks():void
     {  
        this.countdown.stop();     
         for(var i=0;i<this.questions.length;i++)
         {
              console.log(this.questions[i].answerOption+'   selected option '+this.ans[i]);
         } 
         this.countMarks();
         console.log('Marks Scored '+(this.marks));
         for(var i=0;i<this.ans.length;i++)
         {
              console.log('Question No : '+(i+1)+' :');
              if(this.ans[i]!=0) console.log('Correct');
              else console.log('Wrong'); 
         } 
         this.displayMarks=true;
    }
    ngOnInit(){
     this.tid = Number(this.activatedRoute.snapshot.params.id);
     this.activatedRoute.paramMap.subscribe(params => {
        });
      if(this.tid == 1)
        this.title = 'Advanced Algorithms & Complexity'
      else if(this.tid == 2)
        this.title = 'Advanced Computer Networks'
      else if(this.tid == 3)
        this.title = 'Object Oriented Analysis & Design'
      else if(this.tid == 4)
        this.title = 'Advanced Operating Systems'
    }

    getSelectedOption(option:number,index:number)
    {
         this.ans[index]=option;
         //console.log('selected OPtion is '+this.ans[index]);        
    } 
    countMarks()
    {
        for(var i = 0; i < this.questions.length;i++)
        { 
          this.total++;
           if(this.ans[i]==this.questions[i].answerOption)
                this.marks++;
           else
                this.ans[i]=0;        
        } 
        this.marks *= this.questions[0].marks;  
        this.total *= this.questions[0].marks;
    }
    handleEvent(event){
      if(event.action === 'notify'){
        if(this.count == 900)
         this.getMarks();
      this.count++;
      }
    } 
}