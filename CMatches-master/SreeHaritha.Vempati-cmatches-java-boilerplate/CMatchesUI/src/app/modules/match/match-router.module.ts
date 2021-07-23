import{RouterModule,Routes} from '@angular/router';
import{NgModule} from '@angular/core';

import { AuthGuardService } from '../../auth-guard.service';
import { ViewscoreComponent } from './components/viewscore/viewscore.component';
import { MatchcalendarComponent } from './components/matchcalendar/matchcalendar.component';
import { PreviousmatchesComponent } from './components/previousmatches/previousmatches.component';
import { UpcomingComponent } from './components/upcoming/upcoming.component';
import { FavouriteComponent } from './components/favourite/favourite.component';

const matchRoutes: Routes=[
    {
        path:'matches',
     
        children:[
            {
                path:'',
                redirectTo:'/matches/upcoming',
                pathMatch:'full',
                canActivate: [AuthGuardService]

            },
            {
                path:'upcoming',
                component: UpcomingComponent,
                canActivate: [AuthGuardService]
            },


            {
                path:'previousmatches',
                component:PreviousmatchesComponent,
                canActivate: [AuthGuardService]
            },
            {
                path:'favourites',
                component:FavouriteComponent,
                canActivate: [AuthGuardService]

            },
            {
                path:'matchcalendar',
                component:MatchcalendarComponent,
                canActivate: [AuthGuardService]

            },
          
        ]
    }
];


@NgModule({
    imports:[
        RouterModule.forChild(matchRoutes),

    ],
    exports:[
        RouterModule,
    ]
})
export class MatchRouterModule{}