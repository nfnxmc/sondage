import { Component, OnInit } from '@angular/core';
import { ChoiceComponent } from '../choice/choice.component';
import { ChoiceService } from '../choice/service/choice.service';
import { Observable } from 'rxjs/Observable';



@Component({
  selector: 'app-poll',
  templateUrl: './poll.component.html',
  styleUrls: ['./poll.component.css']
})
export class PollComponent implements OnInit {

  private choices: Array<Object>;
  private id: number;
  private ownerId: number;
  private question: string = "Your choice?";
  private errorMessage:string = "";

  private disabled: boolean = true;

  private colors = ["#66ffff", "#6699ff", "#ffccff"];
 
  constructor(private choiceService: ChoiceService) { }

  ngOnInit() {
    this.choiceService.fakeChoices().subscribe(choices => {
      this.choices = choices, error => this.errorMessage = error
    }
    );
  }

  updateChoiceScore(cid: number){
    this.choiceService.updateChoiceScore(cid);
    this.disabled = true;
  }
  
    
   
}
