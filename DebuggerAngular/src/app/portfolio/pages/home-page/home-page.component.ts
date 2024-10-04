import { Component } from '@angular/core';
import { NavBarComponent } from '../../template/nav-bar/nav-bar.component';
import { AgGridAngular } from 'ag-grid-angular';
import { User } from 'src/app/models/user';
import { Chart } from 'chart.js/auto';
import { ColDef } from 'ag-grid-community';
import { TradeServiceService } from 'src/app/services/trade-service.service';
@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent {
  // public person : User = {
  //   firstName:'Swastika',
  //   lastName:'Swastika',
  //   emailId:'swastika.fmri@fmr.com',
  //   username:'swastika-fmr',
  //   country:'INDIA',
  //   dateOfBirth:new Date(1999,12,12),
  //   postalCode:'600028',
  //   panCardIdentification:'XXXXXXXXXX',
  //   password:'SWASTIKA12',
  //   phoneNumber:'7340901032',
  //   accountBalance: '50000'
  // };
  constructor(private tradeService:TradeServiceService){}
  public person=this.tradeService.getUser();

  public chart: any;

   // DefaultColDef sets props common to all Columns
  public defaultColDef: ColDef = {
    sortable: true,
    filter: true,
  };

  columnDefs: ColDef[] = [
    { field: 'security' , headerName:'Security', },
    { field: 'price' , headerName:'Price per share'},
    {field: 'changePercent', headerName:'% P/L', 
    cellStyle: params => {
      if (params.value<0) {
          return {color: 'red'};
      }else{
        return {color: 'green'};
      }
  } 
  }
];

  rowData = [
    {security: 'Tesla', price: 230, changePercent: +2.34},
    {security: 'Meta', price: 180, changePercent: +12.34},
    {security: 'Amazon', price: 320, changePercent: -5.09},
    {security: 'Goldman Sachs', price: 80, changePercent: +9.87},
    {security: 'Alphabet', price: 280, changePercent: -19.75},
    {security: 'Good Year Tyres', price: 48, changePercent: +21.03},
    {security: 'Tesla', price: 230, changePercent: +2.34},
    {security: 'Meta', price: 180, changePercent: +12.34},
    {security: 'Amazon', price: 320, changePercent: -5.09},
    {security: 'Goldman Sachs', price: 80, changePercent: +9.87},
    {security: 'Alphabet', price: 280, changePercent: -19.75},
    {security: 'Good Year Tyres', price: 48, changePercent: +21.03},
    {security: 'Tesla', price: 230, changePercent: +2.34},
    {security: 'Meta', price: 180, changePercent: +12.34},
    {security: 'Amazon', price: 320, changePercent: -5.09},
    {security: 'Goldman Sachs', price: 80, changePercent: +9.87},
    {security: 'Alphabet', price: 280, changePercent: -19.75},
    {security: 'Good Year Tyres', price: 48, changePercent: +21.03},
    {security: 'Tesla', price: 230, changePercent: +2.34},
    {security: 'Meta', price: 180, changePercent: +12.34},
    {security: 'Amazon', price: 320, changePercent: -5.09},
    {security: 'Goldman Sachs', price: 80, changePercent: +9.87},
    {security: 'Alphabet', price: 280, changePercent: -19.75},
    {security: 'Good Year Tyres', price: 48, changePercent: +21.03},
    
    
  ];

  // rowData = [
  //     { make: 'Toyota', model: 'Celica', price: 35000 },
  //     { make: 'Ford', model: 'Mondeo', price: 32000 },
  //     { make: 'Porsche', model: 'Boxster', price: 72000 },
  //     { make: 'Ford', model: 'Mondeo', price: 32000 },
  //     { make: 'Ford', model: 'Mondeo', price: 32000 },
  //     { make: 'Ford', model: 'Mondeo', price: 32000 },
  //     { make: 'Ford', model: 'Mondeo', price: 32000 },
  //     { make: 'Ford', model: 'Mondeo', price: 32000 },
  //     { make: 'Ford', model: 'Mondeo', price: 32000 },
  //     { make: 'Ford', model: 'Mondeo', price: 32000 },
  //     { make: 'Ford', model: 'Mondeo', price: 32000 },
  //     { make: 'Ford', model: 'Mondeo', price: 32000 },
  //     { make: 'Ford', model: 'Mondeo', price: 32000 },
  //     { make: 'Ford', model: 'Mondeo', price: 32000 },
  //     { make: 'Porsche', model: 'Boxster', price: 72000 },
  //     { make: 'Porsche', model: 'Boxster', price: 72000 },
  //     { make: 'Porsche', model: 'Boxster', price: 72000 },
  // ];

  ngOnInit(){
    this.createChart();
  }

  //Create chart using Chart JS
  createChart(){

    this.chart = new Chart("MyChart", {
      type: 'doughnut', //this denotes tha type of chart

      data: {// values on X-Axis
        labels: ['Red', 'Pink','Green','Yellow','Orange','Blue', ],
	       datasets: [{
    label: 'My First Dataset',
    data: [300, 240, 100, 432, 253, 34],
    backgroundColor: [
      'red',
      'pink',
      'green',
			'yellow',
      'orange',
      'blue',			
    ],
    hoverOffset: 4
  }],
      },
      options: {
        aspectRatio:2.5
      }

    });
  }

}
