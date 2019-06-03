multiJob('gdf-facebook/gd-facebook-ad_meta-multi-job') {
	description("<html>"+
  "<br/>"+
  "<br/>"+
  "<table>"+

    "<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>Description	</b>"+	
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ": Multi job which triggers all tasks pulling ad configuration details from facebook "+
      "</td>"+
   	"</tr>"+
    
    "<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>Updates Table	</b>"+	
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ": 	analytics.dw_growth_ad "+
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
        ": facebook/ad_meta.rake "+
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
  
  concurrentBuild()

  label('master')

  disabled(true)

  triggers{
    cron('30 H/4 * * *')
  }

  steps{
    phase('1'){
      phaseJob('gdf-facebook/gd-facebook-ad_meta-102257116603016'){
      killPhaseCondition('NEVER')
      currentJobParameters(true)
      }
      phaseJob('gdf-facebook/gd-facebook-ad_meta-1311786048838263'){
      killPhaseCondition('NEVER')
      currentJobParameters(true)
      }
       phaseJob('gdf-facebook/gd-facebook-ad_meta-1334602183223316'){
      killPhaseCondition('NEVER')
      currentJobParameters(true)
      }
       phaseJob('gdf-facebook/gd-facebook-ad_meta-1368443379839196'){
      killPhaseCondition('NEVER')
      currentJobParameters(true)
      }
       phaseJob('gdf-facebook/gd-facebook-ad_meta-141632906'){
      killPhaseCondition('NEVER')
      currentJobParameters(true)
      }
       phaseJob('gdf-facebook/gd-facebook-ad_meta-1551884058161793'){
      killPhaseCondition('NEVER')
      currentJobParameters(true)
      }
       phaseJob('gdf-facebook/gd-facebook-ad_meta-1368442333172634'){
      killPhaseCondition('FAILURE')
      currentJobParameters(true)
      abortAllJobs(true)
      }
       phaseJob('gdf-facebook/gd-facebook-ad_meta-1318540404829494'){
      killPhaseCondition('FAILURE')
      currentJobParameters(true)
      abortAllJobs(true)
      }
      phaseJob('gdf-facebook/gd-facebook-ad_meta-251434835063079'){
      killPhaseCondition('FAILURE')
      currentJobParameters(true)
      abortAllJobs(true)
      }
      phaseJob('gdf-facebook/gd-facebook-ad_meta-1994247617556775'){
      killPhaseCondition('FAILURE')
      currentJobParameters(true)
      abortAllJobs(true)
      }
      phaseJob('gdf-facebook/gd-facebook-ad_meta-770511926480165'){
      killPhaseCondition('FAILURE')
      currentJobParameters(true)
      abortAllJobs(true)
      }
      phaseJob('gdf-facebook/gd-facebook-ad_meta-1382302458648953'){
      killPhaseCondition('FAILURE')
      currentJobParameters(true)
      abortAllJobs(true)
      }
      executionType('SEQUENTIALLY')
      continuationCondition('ALWAYS')
    }
  }

}