import { Component, OnInit } from '@angular/core';
import { ChoiceService } from '../../choice/service/choice.service';
import { Subscription } from 'rxjs/Subscription';
import * as d3 from "d3";


@Component({
  selector: 'app-chart',
  templateUrl: './chart.component.html',
  styleUrls: ['./chart.component.css']
})
export class ChartComponent implements OnInit {
  private choices:Array<any>;
 
  view = [300, 220];
  results = [];
  // options
  showXAxis = true;
  showYAxis = true;
  gradient = false;
  showLegend = true;
  showXAxisLabel = true;
  xAxisLabel = 'Choices';
  showYAxisLabel = true;
  yAxisLabel = 'Score';

  colorScheme = {
    domain: ['#5AA454', '#A10A28', '#C7B42C', '#AAAAAA']
  };
  
  constructor(private cs: ChoiceService) { }

  ngOnInit() {
    this.cs.fakeChoices().subscribe(choices => {
      this.choices = choices;
      this.results = choices.map((c) => {return {name: c.name, value: c.score}});
    }).unsubscribe();
    
  }

  createChart(choices){
  }
}
