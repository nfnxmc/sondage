import { Component, OnInit, Input } from '@angular/core';
import { ChoiceComponent } from '../choice/choice.component';
import { ChoiceService } from '../choice/service/choice.service';
import { Observable } from 'rxjs/Observable';



@Component({
  selector: 'app-poll',
  templateUrl: './poll.component.html',
  styleUrls: ['./poll.component.css']
})
export class PollComponent implements OnInit {

  // Drawing data
 
  private disabled: boolean = true;
  private colors = ["#66ffff", "#6699ff", "#ffccff"];

  // model data
  @Input('choices') choices: Array<Object>;
  @Input('ownerId') ownerId: number;
  @Input('id') id: number;
  private question: string = "Your choice?";
  private errorMessage:string = "";

  constructor(private choiceService: ChoiceService) { }

  ngOnInit() {

  }

  updateChoiceScore(cid: number){
    this.choiceService.updateChoiceScore(cid);
    this.disabled = true;
  }
  
    
   
}
