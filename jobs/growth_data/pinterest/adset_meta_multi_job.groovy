multiJob('gdf-pinterest/gd-pinterest-adset_meta-multi_job') {
  description("<html>"+
  "<br/>"+
  "<br/>"+
  "<table>"+
    "<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>Description  </b>"+  
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ": Multi job which triggers pinterest task pulling adset meta information "+
      "</td>"+
    "</tr>"+
    
    "<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>Updates Table  </b>"+  
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ":  analytics.dw_growth_adset "+
      "</td>"+
    "</tr>"+

    "<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>Owner  </b>"+  
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ":  kamal@poshmark.com, parthiban@poshmark.com "+
      "</td>"+
    "</tr>"+

    "<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>Rake File  </b>"+  
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ": ppinterest/adset_meta.rake "+
      "</td>"+
    "</tr>"+

    "<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>Git  </b>"+  
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ": NA"+
      "</td>"+
    "</tr>"+
    
    "<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>JIRA </b>"+  
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ": NA"+
      "</td>"+
    "</tr>"+

  "</table>"+
"</html>")

  weight(1)
  
  concurrentBuild(true)

  label('master')

  disabled(true)
  
  triggers{
    cron('30 H/4 * * *')
  }

  steps{
    phase('1'){
      phaseJob('gdf-pinterest/gd-pinterest-adset_meta'){
      killPhaseCondition('FAILURE')
      abortAllJobs(true)
      currentJobParameters(true)
      }
      executionType('PARALLEL')
      continuationCondition('ALWAYS')
    }
  }

}
