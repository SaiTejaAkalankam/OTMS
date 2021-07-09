import { Component , OnInit} from '@angular/core';
import { AddTestService } from './add-service';
import { Test } from './test';
@Component({
   selector: 'test-list',  
   templateUrl: './test-list.component.html'
})
export class TestListComponent implements OnInit
{

    tests:Test[];
    public constructor(private addtestService: AddTestService){}
    public getTests():void
    {
       this.addtestService.getTests().subscribe(data => this.tests=data);
    }
    ngOnInit(){}
}