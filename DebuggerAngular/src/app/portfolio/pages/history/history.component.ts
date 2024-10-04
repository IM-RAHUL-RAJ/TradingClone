import { Component } from '@angular/core';
import { NavBarComponent } from '../../template/nav-bar/nav-bar.component';
import { FooterComponent } from '../../template/footer/footer.component';
import { history } from 'src/app/models/history';

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent {
    history:history[]=[
      {'company':'fidelity',
        'action':'buy',
        'date':'12/02/2000',
        'time':'16:00',
        'shares':5,
        'price':5000,
        'balance':150000
      },
      {
        'company':'JPMC',
        'action':'sell',
        'date':'12/02/2001',
        'time':'12:00',
        'shares':7,
        'price':6000,
        'balance':150000
      },{
        'company':'cisco',
        'action':'buy',
        'date':'12/02/2000',
        'time':'10:00',
        'shares':10,
        'price':15000,
        'balance':120000
      }


    ];

  search:string='';

  filterTable(){
      return this.history.filter(item=>
        item.company.toLowerCase().includes(this.search.toLowerCase())
      );
    }
}
