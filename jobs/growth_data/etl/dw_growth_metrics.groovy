freeStyleJob('gdf-etl/gd-etl-dw_growth_metrics') {
	description("<html>"+
  "<br/>"+
  "<br/>"+
  "<table>"+
    "<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>Description	</b>"+	
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ": ETLs orders from raw_spark.orders, listings from raw_spark.listings, reg_attributions from vw_last_click_reg_attribution, estimated_spend from dw_spend_estimates, computed_spend from vw_computed_spend, installs from dw_install_attribution, campaign metadata from dw_growth_campaign, spend data from all attribution partners from dw_acquisition_spend then loads into dw_growth_metrics table "+
      "</td>"+
   	"</tr>"+
    
    "<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>Updates Table	</b>"+	
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ": analytics.dw_growth_metrics "+
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
        ":	etl/dw_daily_growth_metrics.rake "+
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
    cron('0,30 6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23 * * *')
  }

  wrappers {
    timeout {
      absolute(20)
      failBuild()
    }
  }

  steps{
    shell('#!/bin/bash --login -x\n\nbash $WORKSPACE/docker_scripts/etl/dw_daily_growth_metrics.sh')
  }

  publishers {
    downstream('SA_Android_Women_Growth_Unit_Performance_Trends,SA_growth_dashboards_hourly,SA_kamal_time_dilation_dash,SA_iPhone_Women_Growth_Unit_Performance_Trends', 'UNSTABLE')
  }

}
