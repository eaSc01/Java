# Get the current directory where the script is running
$currentDir = Get-Location

# Get all .class files recursively from the current directory
$files = Get-ChildItem -Path $currentDir -Recurse -Filter "*.class"

# Delete each .class file
foreach ($file in $files) {
    Remove-Item -Path $file.FullName -Force
}

Write-Host "All .class files have been deleted."