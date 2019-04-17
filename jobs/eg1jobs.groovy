String repo="parthibanposhmark/hello-world"
job("example1"){
	scm{
		github repo
	}
	triggers{
		scm 'H/5 * * * *'
	}
} 

dashboardView('example') {
    jobs {
        regex(/example1/)
    }
    columns {
        status()
        weather()
        buildButton()
    }
    topPortlets {
        jenkinsJobsList {
            displayName('acme jobs')
        }
    }
    leftPortlets {
        testStatisticsChart()
    }
    rightPortlets {
        testTrendChart()
    }
    bottomPortlets {
        iframe {
            effectiveUrl('http://example.com')
        }
        testStatisticsGrid()
        buildStatistics()
    }
}