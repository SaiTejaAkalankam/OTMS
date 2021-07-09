import { Component , OnInit } from '@angular/core';
import { AddTestService } from './add-service';
import { Test } from './test';
import {Router} from '@angular/router';

@Component({
    selector: 'add-test',
    templateUrl: './add-test-component.html'
})
export class AddTestComponent implements OnInit
{
   test:Test=new Test(0,new Date(),'','15',0);
   testId : number;
   newId : number;

   public constructor(private addtestService: AddTestService, private router :Router){}
   public insertTest():void
   {
       this.testId = this.test.testId;
      this.addtestService.checkTestId(this.testId).subscribe((res : any) =>{
        console.log('The user obj is ',res);  this.newId = res;  
        if(!res) {
          var errormsg = confirm("This test Id is already exists ! Please create a test with new test Id.")
          if(errormsg==true)
          {
            this.router.navigate(['/Addtest']);
          } 
          else
          {
          this.router.navigate(['/AdminHome']);
          }
     }

      else {
          this.addtestService.insertTest(this.test).subscribe();
          var a = confirm("New test details are successfully added! You can check the details and re-direct to this page by clicking 'OK' or click 'Cancel' to go back to home!");
          if(a==true)
          {
            this.router.navigate(['/Gettests']);
          } 
          else
          {
          this.router.navigate(['/AdminHome']);
          }
     }
      });
       console.log(this.testId);
   } 

   ngOnInit()
   {
      //this.getTest();
   }

}