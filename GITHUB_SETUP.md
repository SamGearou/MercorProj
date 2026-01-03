# GitHub Repository Setup

## Option 1: Using GitHub CLI (Recommended)

If you have GitHub CLI installed:

```bash
# Authenticate (if not already done)
gh auth login

# Create repository and push
gh repo create MercorProj --public --source=. --remote=origin --push
```

## Option 2: Manual Setup via GitHub Web Interface

1. **Create Repository on GitHub:**
   - Go to https://github.com/new
   - Repository name: `MercorProj`
   - Description: "Object Store Application with Prometheus monitoring and alerting"
   - Choose Public or Private
   - **DO NOT** initialize with README, .gitignore, or license (we already have these)
   - Click "Create repository"

2. **Push to GitHub:**
   ```bash
   # Add remote (replace YOUR_USERNAME with your GitHub username)
   git remote add origin https://github.com/YOUR_USERNAME/MercorProj.git
   
   # Rename branch to main (if needed)
   git branch -M main
   
   # Push to GitHub
   git push -u origin main
   ```

## Option 3: Using SSH (if you have SSH keys set up)

```bash
# Add remote with SSH
git remote add origin git@github.com:YOUR_USERNAME/MercorProj.git

# Rename branch to main (if needed)
git branch -M main

# Push to GitHub
git push -u origin main
```

## After Pushing

Once pushed, your repository will be available at:
- `https://github.com/YOUR_USERNAME/MercorProj`

## Important Notes

- The `alertmanager.yml` file is **NOT** included in the repository (it contains sensitive email passwords)
- An `alertmanager.yml.example` file is included as a template
- Make sure to keep your actual `alertmanager.yml` file local and never commit it
- Docker volumes and build artifacts are excluded via `.gitignore`

