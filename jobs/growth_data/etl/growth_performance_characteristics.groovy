freeStyleJob('gdf-etl/gd-etl-growth_performance_characteristics') {
	description("<html>"+
  "<br/>"+
  "<br/>"+
  "<table>"+
    "<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>Description	</b>"+	
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ": Calculates low_cutoff, high_cutoff, low_avg_daily_spend, low_avg_daily_user_looker, medium_avg_daily_spend, medium_avg_daily_user_looker, high_avg_daily_spend, high_avg_daily_user_looker from dw_growth_metrics for each growth_unit and acq_channel_group_v2 "+
      "</td>"+
   	"</tr>"+
    
    "<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>Updates Table	</b>"+	
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ": analytics_scratch.growth_unit_performance_characteristics, analytics_scratch.acq_channel_performance_characteristics "+
      "</td>"+
   	"</tr>"+

   	"<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>Owner	</b>"+	
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ": 	kamal@poshmark.com, parthiban@poshmark.com "+
      "</td>"+
   	"</tr>"+

   	"<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>Rake File	</b>"+	
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ":	etl/growth_performance_characteristics.rake "+
      "</td>"+
   	"</tr>"+

   	"<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>Git	</b>"+	
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ": NA"+
      "</td>"+
   	"</tr>"+
    
    "<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>JIRA	</b>"+	
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ": NA"+
      "</td>"+
   	"</tr>"+

  "</table>"+
"</html>")

  weight(1)
  
  label('slave')

  disabled(true)

  scm{
     git{
      branch('*/master')
      remote{
        url('https://github.com/ParthibanPoshmark/hello-world')
      }
     }
  }

  triggers{
    cron('H 7 * * *')
  }

  wrappers {
    timeout {
      absolute(20)
      failBuild()
    }
  }

  steps{
    shell('bash $WORKSPACE/docker_scripts/etl/growth_performance_characteristics.sh')
  }

}
